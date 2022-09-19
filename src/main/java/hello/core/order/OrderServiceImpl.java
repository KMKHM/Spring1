package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;

public class OrderServiceImpl implements OrderService{
    private final MemberRepository memberRepository; // 객체의 참조값이 들어간다.
    //private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
    private final DiscountPolicy discountPolicy; // 생성자를 통해 값이 할당된다., DIP가 매우 잘 지켜지고 있다.

    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findbyId(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);
        /*OrderService입장에서는 할인에 대해 아애 모르고 discountPolicy가 알아서 한다.
        * 즉 잘 설계 된 것이라고 볼 수 있다.*/

        return new Order(memberId, itemName, itemPrice ,discountPrice);
    }
}
