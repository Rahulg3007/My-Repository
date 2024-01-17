package com.spotify.test;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import com.spotify.pojo.BollywoodMashupPlaylist;

import io.restassured.RestAssured;

public class createPlaylistWithPojo 
{
	@Test
	public void creatingNewPlaylist()
	{
		
		BollywoodMashupPlaylist reqPlylist = new BollywoodMashupPlaylist();
		reqPlylist.setName("Hollywood Songs");
		
		reqPlylist.setDescription("Hollywood playlist created by restassured");
		
		reqPlylist.setPublic(false);
		
		RestAssured.baseURI = "https://api.spotify.com/v1/users";
		
		 BollywoodMashupPlaylist resPlaylist = given()
		
		.headers("Authorization", "Bearer BQC1sHkLYzBSBR6COtINZBEMfweqjNebNeFBX7QwoPIiVhj62GrEKjtsdntV-Xl5Q53iehu1IxbDRVWvqfD4NUVYWyRTdFcQHDvVDBUhqiDF9qOh_pE2Gc3iczj-kt0K65u0PFZrBhlVz9U8m0wp1BlEYCCEyMpdQH5L1ToPErI1CqbZIwhCJDJo2DMV2Ki00D22cQtCehYXCkSfqGGKpguW9KBWKn-t9z1VsDMZ4t903_7O5fSnqbuw1EPurBbfT2HJji62DJUeR74S")
		
		.body(reqPlylist)
		
		.log()
		
		.all()
		
		.when()
		
		.post("31scfm43vfowwk7lu7ubz4xnsbse/playlists")
		
		.then()
		
		.extract()
		
		.response()
		
		.as(BollywoodMashupPlaylist.class);
		 
		String description = resPlaylist.getDescription();
		
		System.out.println(description);
		
		String idValue = resPlaylist.getId();
		
		System.out.println(idValue);
		
		
	}
}
