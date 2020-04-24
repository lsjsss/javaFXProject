package java_Unit19;

import java_Unit13.Rational;

class java19_12_RationalMatrix extends java19_10_GenericMatrix<Rational> {
    @Override /** Add two rational numbers 有理数相加*/
    protected Rational add(Rational r1, Rational r2) {
        return r1.add(r2);
    }
    @Override /** Multiply two rational numbers 有理数相乘*/
    protected Rational multiply(Rational r1, Rational r2) {
        return r1.multiply(r2);
    }
    @Override /** Specify zero for a Rational number 有理数清零*/
    protected Rational zero() {
        return new Rational(0, 1);
    }
}
//13-13

