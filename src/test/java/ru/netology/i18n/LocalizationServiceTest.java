package ru.netology.i18n;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import ru.netology.entity.Country;

class LocalizationServiceTest {

  LocalizationService localizationService;

  @BeforeEach
  public void beforeEach() {
    localizationService = new LocalizationServiceImpl();
  }

  @ParameterizedTest
  @MethodSource("TestData#localization")
  public void getLocaleTest(String expectedResponse, Country country) {
    String response = localizationService.locale(country);
    Assertions.assertEquals(expectedResponse, response);
  }
}