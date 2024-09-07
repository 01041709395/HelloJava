package hello.hello_spring.service;

import hello.hello_spring.domain.Member;
import hello.hello_spring.repository.MemberRepository;
import hello.hello_spring.repository.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
@Service // 순수한 자바 클래스 이기 때문에 스프링이 확인 할 수 있는 방법이 없으므로 Service 어노테이션을 입력해야한다.
public class MemberService {

    private final MemberRepository memberRepository ;

    @Autowired
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    /**
     *
     * @회원가입
     *
     */
    public Long join(Member member) {

    long start = System.currentTimeMillis();




            memberRepository.findByName(member.getName())
                    .ifPresent(m -> {
                        throw new IllegalStateException("이미 존재하는 회원입니다.");
                    });

        memberRepository.save(member);

        return member.getId();
    }

/**
 * 전체 회원 조희
 */
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }
    public Optional<Member> findOne(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
