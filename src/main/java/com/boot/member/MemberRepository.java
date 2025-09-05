package com.boot.member;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MemberRepository {

    public final JdbcTemplate jdbcTemplate;

    //스프링 컨테이너에 등록되어있는 JdbcTemplate 객체를 찾아서 주입
    public MemberRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void initTable() {
        jdbcTemplate.execute("create table member(member_id varchar primary key, name varchar)");
    }

    public void save(Member member) {
        jdbcTemplate.update("insert into member(member_id, name) values(?,?)", member.getMemberId(), member.getName());
    }

    public Member find(String memberId) {
        return jdbcTemplate.queryForObject("select member_id, name from member where member_id=?", BeanPropertyRowMapper.newInstance(Member.class), memberId);
    }

    public List<Member> findAll() {
        return jdbcTemplate.query("select member_id, name from member", BeanPropertyRowMapper.newInstance(Member.class));
    }
}
