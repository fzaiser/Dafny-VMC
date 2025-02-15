/*******************************************************************************
 *  Copyright by the contributors to the Dafny Project
 *  SPDX-License-Identifier: MIT
 *******************************************************************************/

module UniformPowerOfTwo.Interface {
  import Monad
  import Model
  import Rand

  trait {:termination false} Trait {
    ghost var s: Rand.Bitstream

    // The return value u is uniformly distributed between 0 <= u < 2^k where 2^k <= n < 2^(k + 1).
    method UniformPowerOfTwoSample(n: nat) returns (u: nat)
      requires n >= 1
      modifies this
      ensures Model.Sample(n)(old(s)) == Monad.Result(u, s)

  }
}
