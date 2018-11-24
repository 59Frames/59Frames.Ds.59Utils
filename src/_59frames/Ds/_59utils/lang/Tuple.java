package _59frames.Ds._59utils.lang;

public class Tuple<A, B> {
    private A a;
    private B b;

    public Tuple(A a, B b) {
        this.a = a;
        this.b = b;
    }

    public A a() {
        return a;
    }

    public void a(A a) {
        this.a = a;
    }

    public B b() {
        return b;
    }

    public void b(B b) {
        this.b = b;
    }
}
