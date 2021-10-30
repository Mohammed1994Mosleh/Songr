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

		testAlbum = new Album("Thank you Allah" , "Maher zain" , 10 , 2500 , "https://i.ytimg.com/vi/BfStqxizSDM/maxresdefault.jpg");

		/* Test Constructor */
		assertTrue(testAlbum instanceof Album);

		/* Test title setter and getter */
		testAlbum.setTitle("dreams");
		assertEquals("dreams", testAlbum.getTitle());

		/* Test artist setter and getter */
		testAlbum.setArtist("Aseel");
		assertEquals("Aseel", testAlbum.getArtist());

		/* Test number of songs setter and getter */
		testAlbum.setSongCount(5);
		assertEquals(5, testAlbum.getSongCount());

		/* Test length setter and getter */
		testAlbum.setLength(3000);
		assertEquals(3000, testAlbum.getLength());

		/* Test image setter setter and getter */
		testAlbum.setImageUrl("none");
		assertEquals("none", testAlbum.getImageUrl());
	}

//	 Test Songs Class
	@Test public void songConstructor(){

		Song testSong = new Song("Thank you Allah" ,  120 , 1 ,testAlbum );

		/* Test Constructor */
		assertTrue(testSong instanceof Song);

		/* Test title setter and getter */
		testSong.setTitle("newSong");
		assertEquals("newSong", testSong.getTitle());

		/* Test artist setter and getter */
		testSong.setLength(200);
		assertEquals( 200 , testSong.getLength());

		/* Test number of songs setter and getter */
		testSong.setTrackNumber(5);
		assertEquals(5, testSong.getTrackNumber());

	}


}
