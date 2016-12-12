/*https://lagunita.stanford.edu/courses/DB/SQL/SelfPaced/courseware/ch-sql/seq-exercise-sql_movie_query_core/
Find the titles of all movies directed by Steven Spielberg*/
SELECT title FROM movie
WHERE director = 'Steven Spielberg';

/*Find all years that have a movie that received a rating of 4 or 5, and sort them in increasing order. */
SELECT distinct year FROM movie M
JOIN rating R on M.mID = R.mID
WHERE stars >= 4
order by year;

/*Find the titles of all movies that have no ratings. */
SELECT title FROM movie M
LEFT JOIN rating R on M.mID = R.mID
WHERE stars IS NULL;

/*Some reviewers didn't provide a date with their rating. Find the names of all reviewers who have ratings with a NULL value for the date.*/
SELECT name FROM reviewer Re
JOIN rating Ra on Re.rID = Ra.rID 
WHERE ratingDate IS NULL;

/*Write a query to return the ratings data in a more readable format: reviewer name, movie title, stars,
and ratingDate. Also, sort the data, first by reviewer name, then by movie title, and lastly by number of stars. */
SELECT name, title, stars, ratingDate
FROM rating
join reviewer on rating.rID = reviewer.rID
join movie on rating.mID = movie.mID
order by name, title, stars;

/*For all cases where the same reviewer rated the same movie twice and gave it a higher rating the
second time, return the reviewer's name and the title of the movie.*/
select P.name, M.title from Rating R
join 
(
  select rID, mId 
  from Rating 
  group by rId, mID 
  having count(*) = 2
) as R2 on R2.mId = R.mId and R2.rID = R.rId
join reviewer P on P.rID = R.rID
join movie M on M.mID = R.mID
where exists (
  select 1 
  from Rating R3 
  where R3.rId = R.rID 
  and R3.mID = R.mId 
  and R3.ratingDate < R.ratingDate 
  and R3.stars < R.stars);
  
/*For each movie that has at least one rating, find the highest number of stars that movie received.
Return the movie title and number of stars. Sort by movie title.*/

SELECT title, max(stars)
FROM rating
join movie on rating.mID = movie.mID
group by title
order by title;

/*For each movie, return the title and the 'rating spread', that is, the difference between highest
and lowest ratings given to that movie. Sort by rating spread from highest to lowest, then by movie title.*/

SELECT title, MAX(stars)-MIN(stars) AS ratingSpread
FROM rating
join movie on rating.mID = movie.mID
group by title
order by ratingSpread desc, title;

/*Find the difference between the average rating of movies released before 1980 and the average
rating of movies released after 1980. (Make sure to calculate the average rating for each movie,
then the average of those averages for movies before 1980 and movies after. Don't just calculate
the overall average rating before and after 1980.)*/ 

select abs(sub2.field1-sub3.field2) from 
(select avg(sub.average) as field1 from
(SELECT year, avg(stars) as average
FROM rating
join movie on movie.mID = rating.mID
group by title) sub
where sub.year>1980) sub2
join ((select avg(sub.average) as field2 from
(SELECT year, avg(stars) as average
FROM rating
join movie on movie.mID = rating.mID
group by title) sub
where sub.year<1980)) sub3;

