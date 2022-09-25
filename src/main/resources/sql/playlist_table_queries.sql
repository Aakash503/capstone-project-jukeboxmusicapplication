use jukebox;
insert into myfavorate (songId,songName,albumName,genre,artistName,songPath)
select songId,songName,albumName,genre,artistName,songPath
from songs where songId=1;

-- adding song to playlist from songs playlist
insert into myfavorate (songId,songName,albumName,genre,artistName,songPath) select songId,songName,albumName,genre,artistName,songPath from songs where songId=1

// deleting a song from playlist
delete from myfavorate where songId=3

-- creating a listOfPlaylist to save all the playlists
use jukebox;
create table jukebox.listofPlaylist
(playListId int primary key auto_increment,
playListName varchar(100)
);

--inserting a playlistname and playlistId in listOfPlaylist
insert into `jukebox`.`listofplaylist`(playlistId,playlistName)values(1,'myfavorate');

