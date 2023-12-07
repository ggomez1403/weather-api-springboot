package org.adaschool.Weather;

import org.adaschool.Weather.controller.WeatherReportController;
import org.adaschool.Weather.data.WeatherReport;
import org.adaschool.Weather.service.WeatherReportService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
class WeatherApplicationTests {

	@Test
	void contextLoads() {
	}

	@Mock
	private WeatherReportService weatherReportService;

	@InjectMocks
	private WeatherReportController weatherReportController;

	@Test
	public void getWeatherReport_WithValidInput_ShouldReturnWeatherReport() {
		// Arrange
		double latitude = 37.8267;
		double longitude = -122.4233;
		WeatherReport expected = new WeatherReport();
		expected.setTemperature(298);
		expected.setHumidity(80);

		when(weatherReportService.getWeatherReport(latitude, longitude))
				.thenReturn(expected);

		// Act
		WeatherReport actual = weatherReportController.getWeatherReport(latitude, longitude);

		// Assert
		assertEquals(expected, actual);
	}

	@Test
	public void getWeatherReport_ShouldCallService() {
		// Arrange
		double latitude = 37.8267;
		double longitude = -122.4233;
		WeatherReport expected = new WeatherReport();

		when(weatherReportService.getWeatherReport(latitude, longitude))
				.thenReturn(expected);

		// Act
		weatherReportController.getWeatherReport(latitude, longitude);

		// Assert
		verify(weatherReportService).getWeatherReport(latitude, longitude);
	}
}
