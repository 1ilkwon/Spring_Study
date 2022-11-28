package hello.core.beanfind;

import hello.core.AppConfig;
import hello.core.member.MemberService;

import hello.core.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ApplicationContextBasicFindTest {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("빈 이름으로 조회")
    void FindBeanByName() {
        MemberService memberService = ac.getBean("memberService", MemberService.class);
        Assertions.assertThat(memberService).isInstanceOf(MemberServiceImpl.class);

    }

    @Test
    @DisplayName("빈 이름없이 타입으로만 조회")
    void FindBeanByType() {
        MemberService memberService = ac.getBean(MemberService.class);
        Assertions.assertThat(memberService).isInstanceOf(MemberServiceImpl.class);

    }


    @Test
    @DisplayName("구체 타입으로 조회")
    void FindBeanByName2() {
        MemberService memberService = ac.getBean("memberService",MemberServiceImpl.class);
        Assertions.assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
    }

    @Test
    @DisplayName("빈 이름으로 조회x")
    void findBeanByNameX() {
//        ac.getBean("xxxx", MemberService.class); // NoSuchBeanDefinitionException 발생

        // NoSuchBeanDefinitionException 해당 예외가 앞선 getBean에서 발생하는지 test
        org.junit.jupiter.api.Assertions.assertThrows(NoSuchBeanDefinitionException.class,
                () -> ac.getBean("xxxx", MemberService.class));
    }
}
