package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;

public class AppConfig { // 애플리케이션에 대한 환경설정은 모두 여기서 한다.
    public MemberService memberService() {
        // 생성자 주입
        return new MemberServiceImpl(memberRepository());
    }

    private MemberRepository memberRepository() { // 코드가 바뀌면 이부분만 변경해주면 된다.
        return new MemoryMemberRepository();
    }
    // AppConfig가 의존관계 역전을 해준다.
    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    public DiscountPolicy discountPolicy() {
        // return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }
}
