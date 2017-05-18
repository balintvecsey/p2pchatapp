package com.greenfoxacademy;

import com.greenfoxacademy.models.ChatMessage;
import com.greenfoxacademy.repository.ChatMessageRepo;
import com.greenfoxacademy.repository.ChatUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class P2pchatappApplication implements CommandLineRunner{

	@Autowired
	ChatUserRepo chatUserRepo;

	@Autowired
	private ChatMessageRepo chatMessageRepo;

	public static void main(String[] args) {
		SpringApplication.run(P2pchatappApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		chatMessageRepo.save(new ChatMessage("App", "Hi there! Submit your message using the send button!"));
	}
}
