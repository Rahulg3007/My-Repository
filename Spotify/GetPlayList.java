package Spotify;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class GetPlayList
{
	@Test
	public void getPlayListInfo()
	{
RestAssured.baseURI = "https://api.spotify.com/v1/";
		
		given()
		
		.headers("Authorization", "Bearer BQAbIYqh5Ye3xvImA9eYg8DBURcW3JJg-MnzX4BZYJyQz2pUvbdagSauCjADrdXwvhn5rnNcy8P33GIpJ6ECltM3SShlhfhAl__CF5NNLlCBwhL62jjh-zdXI4xuappXx6TQsKQr1dYgprNvb3ooSaZrVjhuiaVu6Yet8y4q0moSR0V0Lr3S37dPKZmlZtXlTfosntNLFR3thrErMYCsisyQ__UG5lzpqpkOuvLYHCSmOwsbSMtpqPECOXSm7u7xyMqS8c01SOcrD-2q")
		
		.log().all()
		
		.when()
		
		.get("playlists/0oTaz7fjXQC6Zd37EtYltY")
		
		.then()
		
		.log().all();
	}
}
