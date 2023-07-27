package com.mytrackmysql.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TrackRepository extends JpaRepository<Track, Long> {

    Track findTrackByTrackNumber(int trackNumber);

    @Query(value = "SELECT * FROM mytrackdb.track", nativeQuery = true)
    List<Track> findAllTracks();


}


