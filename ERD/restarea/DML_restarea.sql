DELETE FROM restarea;



INSERT INTO RestArea
			(ra_code, ra_name, ra_routeNo, ra_routeName, ra_destination, ra_xValue, ra_yValue)
		VALUES
			('1', 'a', 'a', 'a', 'a', 'a', 'a');

SELECT * FROM restarea;

SELECT * FROM GASSTATION;

SELECT * FROM FOODMENU;


SELECT RestArea.*
FROM RestArea
WHERE ra_routeName = '경부선' AND ra_DESTINATION ='서울'
ORDER BY ra_code
;

SELECT RestArea.*, ra_like.ra_like_cnt
FROM RestArea
LEFT OUTER JOIN 
(SELECT ra_code, COUNT(*) AS ra_like_cnt
FROM ra_like
GROUP BY ra_code) ra_like ON restarea.ra_code=ra_like.ra_code
ORDER BY ra_like.ra_like_cnt DESC, RestArea.ra_code 
;

SELECT *
FROM RA_LIKE rl ;

SELECT ra_code, COUNT(*) AS ra_like_cnt
FROM ra_like
GROUP BY ra_code;

--경부선 y 서울/부산/양방향
--광주대구선 x 고서/옥포 3
--남해2지선 x 서부산  1
--남해선 x 순천/부산
--동해선 y 부산(하)/포항(상) 삼척(동해)/속초
--무안광주선 x 광주/무안  2
--서울양양선 y 서울/양양 2
--서천공주선 y 서천/공주 4
--서해안선 y 서울/목포/양방향
