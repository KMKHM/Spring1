package hello.core.member;
// 회원가입과 회원조회 두 가지가 있어야 한다.(회원 도메인 협력관계 확인)
public interface MemberService {
    void join(Member member);

    Member findMember(Long memberId);
}
