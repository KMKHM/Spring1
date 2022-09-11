package hello.core.member;

import java.util.HashMap;
import java.util.Map;
// 아직 데이터베이스가 확정되지 않아 메모리를 사용한다.
// 구현체이기 때문에 interface를 implements 해줘야 함
public class MemoryMemberRepository implements MemberRepository {
    // 저장소 생성, 실무에서는 ConcurrentHashMap를 사용한다.(동시성 이슈)
    private static Map<Long, Member> store = new HashMap<>();

    @Override
    public void save(Member member) {
        store.put(member.getId(), member);
    }

    @Override
    public Member findbyId(Long memberId) {
        return store.get(memberId);
    }
}
