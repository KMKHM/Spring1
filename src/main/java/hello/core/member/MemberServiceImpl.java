package hello.core.member;

public class MemberServiceImpl implements MemberService{

    // interface만 가지고 있으면 NullPointerException이 난다.
    // 그래서 구현 객체를 선택한다.
    private final MemberRepository memberRepository;

    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override //MemoryMemberRepository의 save 호출한다.
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findbyId(memberId);
    }
}
