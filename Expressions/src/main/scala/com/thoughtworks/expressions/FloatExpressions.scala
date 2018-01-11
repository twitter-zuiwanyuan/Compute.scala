package com.thoughtworks.expressions

import com.thoughtworks.expressions.Anonymous.Implicitly
import com.thoughtworks.feature.Factory
import com.thoughtworks.feature.Factory.{Factory0, inject}

/**
  * @author 杨博 (Yang Bo)
  */
trait FloatExpressions extends ValueExpressions {

  protected trait FloatTypeApi extends ValueTypeApi { this: FloatType =>
    type JvmType = Float

    def name = "Float"

    def zero(implicit debuggingInformation: Implicitly[DebuggingInformation]): Literal = Literal(0.0f)

    protected trait FloatTypedTermApi extends super.TypedTermApi { this: TypedTerm =>
      def +(rightHandSide: FloatTerm)(implicit debuggingInformation: Implicitly[DebuggingInformation]): FloatTerm = ???
      def *(rightHandSide: FloatTerm)(implicit debuggingInformation: Implicitly[DebuggingInformation]): FloatTerm = ???
    }

    type TypedTerm <: (ValueTerm with Any) with FloatTypedTermApi

  }

  /** @template */
  type FloatType <: (ValueType with Any) with FloatTypeApi

  @inject
  protected def FloatType: Factory0[FloatType]

  val float: FloatType = FloatType.newInstance()

  type FloatTerm = float.TypedTerm

}
