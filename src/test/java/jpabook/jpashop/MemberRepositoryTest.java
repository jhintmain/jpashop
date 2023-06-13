package jpabook.jpashop;

import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@Transactional
class MemberRepositoryTest {

    @Autowired
    MemberRepository memberRepository;


    @Test
    public void testMember() throws Exception {
        // given
        Member member = new Member();
        member.setUsername("member1");

        // when
        Long id = memberRepository.save(member);
        Member member1 = memberRepository.find(id);

        // then
        assertThat(member.getId()).isEqualTo(member1.getId());
        assertThat(member.getUsername()).isEqualTo(member1.getUsername());
        assertThat(member).isEqualTo(member1);
        System.out.println(member == member1);

    }
}