--use jukebox;
--insert into myfavorate (songId,songName,albumName,genre,artistName,songPath)
--select songId,songName,albumName,genre,artistName,songPath
--from songs where songId=1;

-- adding song to playlist from songs playlist
--insert into myfavorate (songId,songName,albumName,genre,artistName,songPath) select songId,songName,albumName,genre,artistName,songPath from songs where songId=1
--
--// deleting a song from playlist
--delete from myfavorate where songId=3

-- creating a listOfPlaylist to save all the playlists
--use jukebox;
--create table jukebox.listofPlaylist
--(playListId int primary key auto_increment,
--playListName varchar(100)
--);

--inserting a playlistname and playlistId in listOfPlaylist
--insert into `jukebox`.`listofplaylist`(playlistId,playlistName)values(1,'myfavorate');

--inserting songs in myfavorate playlist threw songs list
--UPDATE `jukebox`.`myfavorate` SET `songName` = 'kesariya', `albumName` = 'brahmastra', `artistName` = 'arijitsingh' WHERE (`songId` = '1');
--UPDATE `jukebox`.`myfavorate` SET `songName` = 'cookisien', `albumName` = 'naruto', `artistName` = ' tyler bates', `songPath` = 'src/main/resources/songs/Cookiesan_Sombre_Naruto.wav' WHERE (`songId` = '2');
--INSERT INTO `jukebox`.`myfavorate` (`songId`, `songName`, `albumName`, `genre`, `artistName`, `songPath`) VALUES ('3', 'yashuharu', 'naruto', 'rock', 'recardo silva', 'src/main/resources/songs/Yasuharu_Takanashi_Scene_of_a_Disaster.wav');
--UPDATE `jukebox`.`songs` SET `songName` = 'celtic', `albumNAme` = 'the whistle', `genre` = 'pop', `artistName` = 'julius', `songPath` = 'src/main/resources/songs/celtic-irish-scottish-tin-whistle-background-music-10455.wav' WHERE (`songId` = '6');
