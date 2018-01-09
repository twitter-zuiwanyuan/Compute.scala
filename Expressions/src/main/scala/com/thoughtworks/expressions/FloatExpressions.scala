package com.thoughtworks.expressions

import com.thoughtworks.expressions.Anonymous.Implicitly
import com.thoughtworks.feature.Factory
import com.thoughtworks.feature.Factory.inject

/**
  * @author 杨博 (Yang Bo)
  */
trait FloatExpressions extends ValueExpressions {

  protected trait FloatTypeApi extends ValueTypeApi { this: FloatType =>
    type JvmType = Float

    def zero(implicit debuggingInformation: Implicitly[DebuggingInformation]): Literal = Literal(0.0f)
  }

  /** @template */
  type FloatType <: (ValueType with Any) with FloatTypeApi

  @inject protected def FloatType: Factory.Factory1[DebuggingInformation, FloatType]

  val float: FloatType = FloatType.newInstance(debuggingInformation)

  type FloatTerm = float.TypedTerm

}
