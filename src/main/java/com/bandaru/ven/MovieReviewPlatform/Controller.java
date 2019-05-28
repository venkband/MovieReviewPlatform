package com.bandaru.ven.MovieReviewPlatform;

import com.bandaru.ven.MovieReviewPlatform.entities.Movie;
import com.bandaru.ven.MovieReviewPlatform.entities.Review;
import com.bandaru.ven.MovieReviewPlatform.entities.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@RestController
public class Controller {

    @Autowired
    NamedParameterJdbcTemplate jdbc;

    Logger logger = LogManager.getLogger();

    @PostMapping("/addMovie")
    public void addMovie(@RequestBody Movie m) {
        String query = "insert into movie(name , year , genre) values(:val1 ,:val2,:val3)";

        MapSqlParameterSource input = new MapSqlParameterSource();
        input.addValue("val1", m.getName());
        input.addValue("val2", m.getYear());
        input.addValue("val3", m.getGenre());

        jdbc.update(query, input);
    }

    @PostMapping("/addUser")
    public void addUser(@RequestBody User u) {
        String qry = "insert into user (user , reviewed_movies , flg_critic) values (:val1,:val2,:val3)";

        MapSqlParameterSource inp = new MapSqlParameterSource();
        inp.addValue("val1", u.getUser());
        inp.addValue("val2", 0);
        inp.addValue("val3", false);

        jdbc.update(qry, inp);
    }

    @PostMapping("/addReview")
    public void addReview(@RequestBody Review r) {
        logger.debug("adding review for movie " + r.getName());
        String str = "insert into review (user,name,rating) values(:val1,:val2,:val3)";

        MapSqlParameterSource in = new MapSqlParameterSource();

        in.addValue("val2", r.getName());
        in.addValue("val1", r.getUser());
        in.addValue("val3", r.getRating());

        // enter review
        jdbc.update(str, in);

        // update no of review in user table and update critic flag if required
        str = "select count(*) as review_count from review where user = :val1";

        MapSqlParameterSource int2 = new MapSqlParameterSource();
        int2.addValue("val1", r.getUser());

        List<Integer> queryresults = jdbc.query(str, int2, new RowMapper<Integer>() {

            @Override
            public Integer mapRow(ResultSet rs, int rowNum) throws SQLException {
                return Integer.valueOf(rs.getString("review_count"));
            }
        });

        int review_count = queryresults.get(0);
        boolean flg_critic = (review_count > 3) ? true : false;

        str = "update user set reviewed_movies = :val1 , flg_critic =  :val2 where user = :val3";
        MapSqlParameterSource inp2 = new MapSqlParameterSource();

        inp2.addValue("val1",review_count);
        inp2.addValue("val2",flg_critic);
        inp2.addValue("val3",r.getUser());

        jdbc.update(str,inp2);
    }

}
