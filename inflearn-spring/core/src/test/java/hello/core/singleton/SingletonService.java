package hello.core.singleton;

public class SingletonService {

    // 객체를 미리 생성해두는 가장 단순하고 안전한 방법을 선택 (싱글톤 방식은 매우 많다.)
    private static final SingletonService instance = new SingletonService();

    public static SingletonService getInstance() {
        return instance;
    }

    // private로 설정하여 외부에서 new 키워드로 객체 인스턴스가 생성되는 것을 막는다.
    private SingletonService(){

    }
    public void logic () {
        System.out.println("싱글톤 객체 호출");
    }


}
