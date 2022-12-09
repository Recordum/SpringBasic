package com.Recordum.start.repository;

import com.Recordum.start.domain.Member;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MemoryMemberRepositoryTest {

    MemoryMemberRepository repository = new MemoryMemberRepository();
    @AfterEach
    public  void afterEach() {

        repository.clearStore();
    }
    @Test
    public void save(){
        Member member = new Member();
        member.setName("spring");

        repository.save(member);

        Member result = repository.findById(member.getId()).get();
        Assertions.assertEquals(member, result);

    }

    @Test
    public void findByName(){
        Member member1 = new Member();
        member1.setName("Spring1");

        repository.save(member1);

        Member result = repository.findByName("Spring1").get();
        Assertions.assertEquals(member1, result);
    }
}
