package DafnyVMC;

import dafny.TypeDescriptor;
import java.math.BigInteger;
import java.security.SecureRandom;

public class Random implements DafnyVMCTrait.RandomTrait {
  static ThreadLocal<SecureRandom> rng;
  
  public Random() {
    this.rng = ThreadLocal.withInitial(Random::createSecureRandom);
  }

  public Random(SecureRandom rng) {
    this.rng = ThreadLocal.withInitial(() -> rng);
  }

  private static final SecureRandom createSecureRandom() {
    final SecureRandom rng = new SecureRandom();
    // Required for proper initialization
    rng.nextBoolean(); 
    return rng;
  }

  public BigInteger UniformPowerOfTwoSample(BigInteger n) {
    if (n.compareTo(BigInteger.ONE) < 0) {
      throw new IllegalArgumentException("n must be positive");
    }

    return new BigInteger(n.bitLength()-1, rng.get());
  }

  public java.math.BigInteger UniformIntervalSample(java.math.BigInteger a, java.math.BigInteger b) {
    return Uniform.Interface._Companion_Trait.UniformIntervalSample(this, a, b);
  }

  public java.math.BigInteger UniformSample(java.math.BigInteger n) {
    return Uniform.Implementation._Companion_Trait.UniformSample(this, n);
  }

  public boolean CoinSample() {
    return Coin.Implementation._Companion_Trait.CoinSample(this);
  }

  public boolean BernoulliSample(Rationals.Rational p) {
    return Bernoulli.Implementation._Companion_Trait.BernoulliSample(this, p);
  }  

  public boolean BernoulliExpNegSampleCaseLe1(Rationals.Rational gamma) {
    return BernoulliExpNeg.Implementation._Companion_Trait.BernoulliExpNegSampleCaseLe1(this, gamma);
  }

  public boolean BernoulliExpNegSample(Rationals.Rational gamma) {
    return BernoulliExpNeg.Implementation._Companion_Trait.BernoulliExpNegSample(this, gamma);
  }

  public java.math.BigInteger DiscreteGaussianSample(Rationals.Rational sigma) {
    return DiscreteGaussian.Implementation._Companion_Trait.DiscreteGaussianSample(this, sigma);
  }

  public dafny.Tuple2<Boolean, java.math.BigInteger> DiscreteLaplaceSampleLoop(Rationals.Rational scale) {
    return DiscreteLaplace.Implementation._Companion_Trait.DiscreteLaplaceSampleLoop(this, scale);
  }

  public java.math.BigInteger DisceteLaplaceSampleInnerLoop() {
    return DiscreteLaplace.Implementation._Companion_Trait.DisceteLaplaceSampleInnerLoop(this);
  }

  public java.math.BigInteger DiscreteLaplaceSample(Rationals.Rational scale) {
    return DiscreteLaplace.Implementation._Companion_Trait.DiscreteLaplaceSample(this, scale);
  }

  public <__T> void Shuffle(dafny.TypeDescriptor<__T> _td___T, java.lang.Object a) {
    FisherYates.Implementation._Companion_Trait.Shuffle(_td___T, this, a);
  }

  public void Shuffle(BigInteger[] arr) {
    FisherYates.Implementation._Companion_Trait.Shuffle(TypeDescriptor.BIG_INTEGER, this, arr);
  }

  public void Shuffle(int[] arr) {
    FisherYates.Implementation._Companion_Trait.Shuffle(TypeDescriptor.INT, this, arr);
  }

  public void Shuffle(String[] arr) {
    FisherYates.Implementation._Companion_Trait.Shuffle(TypeDescriptor.CHAR_ARRAY, this, arr);
  }

  public void Shuffle(char[] arr) {
    FisherYates.Implementation._Companion_Trait.Shuffle(TypeDescriptor.CHAR, this, arr);
  }

  public void Shuffle(boolean[] arr) {
    FisherYates.Implementation._Companion_Trait.Shuffle(TypeDescriptor.BOOLEAN, this, arr);
  }

  public void Shuffle(long[] arr) {
    FisherYates.Implementation._Companion_Trait.Shuffle(TypeDescriptor.LONG, this, arr);
  }

  public void Shuffle(short[] arr) {
    FisherYates.Implementation._Companion_Trait.Shuffle(TypeDescriptor.SHORT, this, arr);
  }
}