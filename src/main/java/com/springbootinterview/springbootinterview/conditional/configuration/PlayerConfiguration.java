package com.springbootinterview.springbootinterview.conditional.configuration;

import org.springframework.boot.autoconfigure.condition.ConditionalOnJava;
import org.springframework.boot.autoconfigure.condition.ConditionalOnJava.Range;
import org.springframework.boot.system.JavaVersion;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.springbootinterview.springbootinterview.conditional.PlayerCondition;
import com.springbootinterview.springbootinterview.conditional.entity.Player;

@Configuration
public class PlayerConfiguration {
	
	@Primary
	@Bean
	@Conditional(PlayerCondition.class)
	public Player player1() {
		return new Player("Dembele", "PSG");
	}
	
	@Bean
	@ConditionalOnJava(range =Range.EQUAL_OR_NEWER, value = JavaVersion.SEVENTEEN)
	public Player player2() {
		return new Player("Messi", "MIA");
	}

}
