package com.example.songr;

import com.example.songr.models.Album;
import com.example.songr.models.Song;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class SongrApplicationTests {

	Album testAlbum;

	// Test album Class
	@Test public void albumConstructor(){

		Album testAlbum1=new Album("Kifk Enta","Fayrouz",500,400,"https://i.ytimg.com/vi/LL5WYA3TOTQ/hqdefault.jpg");

		/* Test Constructor */
		assertTrue(testAlbum1 instanceof Album);


		testAlbum1.setTitle("Madrasat Alhob");
		assertEquals("Madrasat Alhob", testAlbum1.getTitle());


		testAlbum1.setArtist("Kathim");
		assertEquals("Kathim", testAlbum1.getArtist());

		/* Test number of songs setter and getter */
		testAlbum1.setSongCount(10);
		assertEquals(10, testAlbum1.getSongCount());

		/* Test length setter and getter */
		testAlbum1.setLength(100);
		assertEquals(100, testAlbum1.getLength());

		/* Test image setter setter and getter */
		testAlbum1.setImageUrl("https://i.ytimg.com/vi/b4nromvjJFc/maxresdefault.jpg");
		assertEquals("https://i.ytimg.com/vi/b4nromvjJFc/maxresdefault.jpg", testAlbum1.getImageUrl());
	}



}
