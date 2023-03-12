package ru.netology.sender;

import java.util.Map;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.Mockito;
import ru.netology.entity.Country;
import ru.netology.entity.Location;
import ru.netology.geo.GeoService;
import ru.netology.i18n.LocalizationService;

class MessageSenderTest {

  static MessageSender messageSender;

  @BeforeAll
  public static void beforeAll() {
    GeoService geoService = Mockito.mock(GeoService.class);
    LocalizationService localizationService = Mockito.mock(LocalizationService.class);
    Mockito.when(geoService.byIp("96.44.183.149"))
        .thenReturn(new Location("New York", Country.USA, " 10th Avenue", 32));
    Mockito.when(geoService.byIp("76.44.183.149"))
        .thenReturn(new Location("Berlin", Country.GERMANY, " 10th Avenue", 32));
    Mockito.when(geoService.byIp("172.0.32.11"))
        .thenReturn(new Location("Moscow", Country.RUSSIA, "Lenina", 15));
    Mockito.when(localizationService.locale(Country.RUSSIA)).thenReturn("Добро пожаловать");
    Mockito.when(localizationService.locale(Country.USA)).thenReturn("Welcome");
    Mockito.when(localizationService.locale(Country.GERMANY)).thenReturn("Welcome");
    messageSender = new MessageSenderImpl(geoService, localizationService);
  }

  @ParameterizedTest
  @MethodSource("TestData#sendData")
  public void getLocationByIpTest(Map<String, String> headers, String expectedResponse) {
    String response = messageSender.send(headers);
    Assertions.assertEquals(expectedResponse, response);
  }
}