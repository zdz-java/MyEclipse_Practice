package com.zdz.springmvc;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.ParseException;
import java.util.List;
import java.util.Locale;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.core.convert.support.DefaultConversionService;
import org.springframework.format.number.CurrencyFormatter;
import org.springframework.format.support.DefaultFormattingConversionService;

import com.zdz.springmvc.converter.StringToPhoneNumberConverter;
import com.zdz.springmvc.formatter.PhoneNumberFormatter;
import com.zdz.springmvc.model.PhoneNumberModel;

public class UnitTest {
	@Test
	public void testStringToPhoneNumberConvert() {
		DefaultConversionService conversionService = new DefaultConversionService();
		conversionService.addConverter(new StringToPhoneNumberConverter());

		String phoneNumberStr = "010-12345678";
		PhoneNumberModel phoneNumber = conversionService.convert(
				phoneNumberStr, PhoneNumberModel.class);

		Assert.assertEquals("010", phoneNumber.getAreaCode());
	}

	@Test
	public void testOtherConvert() {
		DefaultConversionService conversionService = new DefaultConversionService();

		// "1"--->true（字符串“1”可以转换为布尔值true）
		Assert.assertEquals(Boolean.valueOf(true),
				conversionService.convert("1", Boolean.class));

		// "1,2,3,4"--->List（转换完毕的集合大小为4）
		Assert.assertEquals(4, conversionService.convert("1,2,3,4", List.class)
				.size());
	}

	@Test
	public void testFormatter() throws ParseException {
		// 二、CurrencyFormatter：实现货币样式的格式化/解析
		CurrencyFormatter currencyFormatter = new CurrencyFormatter();
		currencyFormatter.setFractionDigits(2);// 保留小数点后几位
		currencyFormatter.setRoundingMode(RoundingMode.CEILING);// 舍入模式（ceilling表示四舍五入）

		// 1、将带货币符号的字符串“$123.125”转换为BigDecimal("123.00")
		Assert.assertEquals(new BigDecimal("123.13"),
				currencyFormatter.parse("$123.125", Locale.US));
		// 2、将BigDecimal("123")格式化为字符串“$123.00”展示
		Assert.assertEquals("$123.00",
				currencyFormatter.print(new BigDecimal("123"), Locale.US));
		Assert.assertEquals("￥123.00",
				currencyFormatter.print(new BigDecimal("123"), Locale.CHINA));
		Assert.assertEquals("￥123.00",
				currencyFormatter.print(new BigDecimal("123"), Locale.JAPAN));
	}

	@Test
	public void testWithDefaultFormattingConversionService() {
		DefaultFormattingConversionService conversionService = new DefaultFormattingConversionService();
		// 默认不自动注册任何Formatter
		CurrencyFormatter currencyFormatter = new CurrencyFormatter();
		currencyFormatter.setFractionDigits(2);// 保留小数点后几位
		currencyFormatter.setRoundingMode(RoundingMode.CEILING);// 舍入模式（ceilling表示四舍五入）
		// 注册Formatter SPI实现
		conversionService.addFormatter(currencyFormatter);

		// 绑定Locale信息到ThreadLocal
		// FormattingConversionService内部自动获取作为Locale信息，如果不设值默认是
		// Locale.getDefault()
		LocaleContextHolder.setLocale(Locale.US);
		Assert.assertEquals("$1,234.13", conversionService.convert(
				new BigDecimal("1234.128"), String.class));
		LocaleContextHolder.setLocale(null);

		LocaleContextHolder.setLocale(Locale.CHINA);
		Assert.assertEquals("￥1,234.13", conversionService.convert(
				new BigDecimal("1234.128"), String.class));
		Assert.assertEquals(new BigDecimal("1234.13"),
				conversionService.convert("￥1,234.13", BigDecimal.class));
		LocaleContextHolder.setLocale(null);
	}
	
	@Test  
    public void testDIYFormatter() {  
        DefaultFormattingConversionService conversionService = new DefaultFormattingConversionService();  
        conversionService.addFormatter(new PhoneNumberFormatter());  
  
        PhoneNumberModel phoneNumber = new PhoneNumberModel("010", "12345678");  
        Assert.assertEquals("010-12345678", conversionService.convert(phoneNumber, String.class));  
          
        Assert.assertEquals("010", conversionService.convert("010-12345678", PhoneNumberModel.class).getAreaCode());  
    }  
}
