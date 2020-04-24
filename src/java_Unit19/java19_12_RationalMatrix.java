package java_Unit19;

import java_Unit13.Rational;

class java19_12_RationalMatrix extends java19_10_GenericMatrix<Rational> {
    @Override /** 有理数相加 Add two rational numbers */
    protected Rational add(Rational r1, Rational r2) {
        return r1.add(r2);
    }
    @Override /** 有理数相乘 Multiply two rational numbers */
    protected Rational multiply(Rational r1, Rational r2) {
        return r1.multiply(r2);
    }
    @Override /** 有理数清零 Specify zero for a Rational number */
    protected Rational zero() {
        return new Rational(0, 1);
    }
}
