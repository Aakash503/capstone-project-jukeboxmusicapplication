use jukebox;
insert into myfavorate (songId,songName,albumName,genre,artistName,songPath)
select songId,songName,albumName,genre,artistName,songPath
from songs where songId=1;

// adding song to playlist from songs playlist
insert into myfavorate (songId,songName,albumName,genre,artistName,songPath) select songId,songName,albumName,genre,artistName,songPath from songs where songId=1

// deleting a song from playlist
delete from myfavorate where songId=3
