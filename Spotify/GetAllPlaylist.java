package Spotify;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class GetAllPlaylist 
{
	@Test
	public void creatingNewPlaylist()
	{
		RestAssured.baseURI = "https://api.spotify.com/v1/users";
		
		given()
		
		.headers("Authorization", "Bearer BQBb7oCdYHQhtP4fSIfsOE4py6dfp0NfiVfxI881WZxD8ZUFPSRO-vU7jHwWP8pGGvfz2jylPeRcExka7GvJEBdeO_3QMcIVbdZ98carmoTwFsnqZDQVc_jCuI4719bXAFW1az05Qb4ljI882qTWvqRT7XVf8kLz8yGB7A5wJZyGMQOGiTxmzTGx0tfit1q3Fl9gri-p7uxC0M0VwNHyzZnG2-UMsMdHApsV0dIX3ONzGRv3TFukT8RRseFfTHbU2BwiQ9j6fFUZtqG-")
		
		.log().all()
		
		.when()
		
		.get("31scfm43vfowwk7lu7ubz4xnsbse/playlists")
		
		.then()
		
		.log().all();
		
		
	}
}
