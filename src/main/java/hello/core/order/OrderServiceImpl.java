package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService{
    private final MemberRepository memberRepository = new MemoryMemberRepository();
    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findbyId(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);
        /*OrderService입장에서는 할인에 대해 아애 모르고 discountPolicy가 알아서 한다.
        * 즉 잘 설계 된 것이라고 볼 수 있다.*/

        return new Order(memberId, itemName, itemPrice ,discountPrice);
    }
}
