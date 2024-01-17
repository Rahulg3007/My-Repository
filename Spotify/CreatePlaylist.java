package Spotify;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

import static io.restassured.RestAssured.*;

public class CreatePlaylist
{
	@Test
	public void creatingNewPlaylist()
	{
		RestAssured.baseURI = "https://api.spotify.com/v1/users";
		
		given()
		
		.headers("Authorization", "Bearer BQB6mh-ia-_b7HIsUbl3PTWKiut_zVILC-HrcBdnyff1z5VPuh0TWhnFM-1CWOElWxDuixOxNqIiwQsrV7t-LNAwssIcmYdMh47oyqQjHyaLVm6yJB9i0UZNXpSzoxtKZp-cllR39NDJxjHqcYyT7n0mIebwymmBbP5rTyLdl-ePBT1UgA8Pyx35h0-wbBRTCFiw2-_XnWrstSqs2iDoRsVEFYvRTtodVJCZh2Y0e66EVtNSrYX6tdIrsA_q73-x-znUKOuT_rISpdyL")
		
		.body("{\r\n"
				+ "    \"name\": \"New Playlist2\",\r\n"
				+ "    \"description\": \"ATT New Playlist\",\r\n"
				+ "    \"public\": false\r\n"
				+ "}")
		.log().all()
		
		.when()
		
		.post("31scfm43vfowwk7lu7ubz4xnsbse/playlists")
		
		.then()
		
		.log().all();
		
		
	}
}
