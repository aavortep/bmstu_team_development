package ru.bmstu.portfolio.factory

import org.mockito.ArgumentMatchers.any
import org.mockito.Mockito.when
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should
import org.scalatestplus.mockito.MockitoSugar.mock
import org.scalatestplus.scalacheck.ScalaCheckPropertyChecks
import ru.bmstu.portfolio.dto.EmptyOptionException
import ru.bmstu.portfolio.factory.provider.{ConstProvider, TProvider}

import scala.language.postfixOps

class TableGatewayFactoryTest extends AnyFlatSpec with should.Matchers with ScalaCheckPropertyChecks {
  "instance" should "throw no_provider error" in {
    //Arrange
    val testFactory = mock[TableGatewayFactory]
    //Act
    TableGatewayFactory.registerFactory("mock", testFactory)
    //Assert
    val thrown: String = intercept[EmptyOptionException] { TableGatewayFactory instance }.getMessage
    thrown should be("Provider is not set")
  }

  "instance" should "throw error as no value found for provider key" in {
    //Arrange
    val testFactory = mock[TableGatewayFactory]
    val provider = mock[TProvider]
    when(provider.getValue(any[String])).thenReturn(None)

    //Act
    TableGatewayFactory.setProvider(provider)
    TableGatewayFactory.registerFactory("mock", testFactory)

    //Assert
    val thrown: String = intercept[EmptyOptionException] { TableGatewayFactory instance }.getMessage
    thrown should be("No value for key in provider")
  }

  "instance" should "throw error as no factory for key in map" in {
    //Arrange
    val provider = new ConstProvider("NoFactory")

    //Act
    TableGatewayFactory.setProvider(provider)

    //Assert
    val thrown: String = intercept[EmptyOptionException] { TableGatewayFactory instance }.getMessage
    thrown should be("Factory is not registered")
  }

  "instance" should "return registered factory" in {
    //Arrange
    val testFactory = mock[TableGatewayFactory]
    val provider = new ConstProvider("mock")

    //Act
    TableGatewayFactory.setProvider(provider)
    TableGatewayFactory.registerFactory("mock", testFactory)

    //Assert
    TableGatewayFactory.instance should be(testFactory)
  }
}