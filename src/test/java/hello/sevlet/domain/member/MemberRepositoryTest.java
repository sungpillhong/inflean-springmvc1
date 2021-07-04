package hello.sevlet.domain.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class MemberRepositoryTest {

    MemberRepository memberRepository = MemberRepository.getInstance();

    @AfterEach
    void afterEach(){
        memberRepository.clearStore(); //순서가 보장이 안되기 때문에 clear해줘야함.
    }

    @Test
    void save(){
        //given
        Member member = new Member("hello",20);
        //when
        Member savedMember = memberRepository.save(member);
        //then
        Member findMember = memberRepository.findById(savedMember.getId());
        assertThat(findMember).isEqualTo(savedMember);
    }

    @Test
    void findAll(){
        //given
        Member member1 = new Member("hello1",20);
        Member member2 = new Member("hello2",30);

        memberRepository.save(member1);
        memberRepository.save(member2);

        //when
        List<Member> result = memberRepository.findAll();

        //that

        assertThat(result.size()).isEqualTo(2); //사이즈가 2개인가? 위에서 2개를 담아줘서
        assertThat(result).contains(member1,member2); //result안에 member1과 2가 있냐
    }
}