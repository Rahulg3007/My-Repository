package com.spotify.test;

import org.testng.annotations.Test;

import com.spotify.pojo.BollywoodMashupPlaylist;

import Optimized_SpecBuilder.specBuilder;
import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
public class CreatePlaylistWithSpecBuilder 
{
	String playlistId;

		@Test()
		public void creatingPlaylist()
		{
			
			BollywoodMashupPlaylist reqPlylist = new BollywoodMashupPlaylist();
			reqPlylist.setName("My songs playlist34");
			
			reqPlylist.setDescription("Hollywood playlist created by restassured with specBuilder");
			
			reqPlylist.setPublic(false);
			
			
			BollywoodMashupPlaylist resPlaylist = given(specBuilder.reqSpec())
			
			.body(reqPlylist)
			
			.when()
			
			.post("/users/31scfm43vfowwk7lu7ubz4xnsbse/playlists")
			
			.then()
			
			.spec(specBuilder.resSpec())
			
			.extract()
			
			.response()
			
			.as(BollywoodMashupPlaylist.class);
			 
			String description = resPlaylist.getDescription();
				
			System.out.println(description);
				
			playlistId = resPlaylist.getId();
				
			System.out.println(playlistId);
			
		}	
		
			@Test
			public void getPlayListInfo()
			{
				
				BollywoodMashupPlaylist plylist = given(specBuilder.reqSpec())
				
				.pathParam("pid", playlistId)
				
				.log().all()
				
				.when()
				
				.get("playlists/{pid}")
				
				.then()
				
				.spec(specBuilder.resSpec())
				
				.extract()
				
				.response()
				
				.as(BollywoodMashupPlaylist.class);
				
				String plylistdesc = plylist.getDescription();
				
				System.out.println(plylistdesc);
			}
		}
