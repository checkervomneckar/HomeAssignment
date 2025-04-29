# HomeAssignment
Soon the 30th April begins and my 7 days are over...

So here comes the quick "readme":

cd ChristinaBackend

./gradlew bootRun

cd ChristinaFrontend

npm install

npm run dev

The long version I will write tomorrow :-) 


I prefilled the PostgreSQL Database with the following Tables:

customers
1	"Chris"	"XtremeCurrentSaver"	"$2a$10$d1TYdOTq1df7GsiykUsyiuo4RyUYflIogkinfCi4KaLPdCE5etLnK"	"JX"
2	"Tina"	"MegaCurrentUser"	"$2a$10$da/UnMB4id6oX7cIsXt6oO8dLJSle8oVxNgDl/cCaCwvAhP3aM8VK"	"YM"


metering_point
1	"Home"	1
2	"Garage"	1
3	"OuterSpace"	2


consumption
1	1	12.00	"Mwh"	"2024-04-01 03:00:00+03"
2	1	2342.00	"kWh"	"2024-05-01 03:00:00+03"
3	1	345.00	"Mwh"	"2024-06-01 03:00:00+03"
4	1	6456.00	"kWh"	"2024-07-01 03:00:00+03"
5	1	99654.00	"kWh"	"2024-08-01 03:00:00+03"
6	1	77675.00	"kWh"	"2024-09-01 03:00:00+03"
7	1	886.00	"Mwh"	"2024-10-01 03:00:00+03"
8	1	24694.00	"kwh"	"2024-11-01 02:00:00+02"
9	1	443.00	"Mwh"	"2024-12-01 02:00:00+02"
10	1	2953.00	"kWh"	"2025-01-01 02:00:00+02"
11	1	4324.00	"kWh"	"2025-02-01 02:00:00+02"
12	1	7430.00	"kWh"	"2025-03-01 02:00:00+02"
13	2	3442.00	"Mwh"	"2024-04-01 03:00:00+03"
14	2	37.00	"kWh"	"2024-05-01 03:00:00+03"
15	2	6954.00	"Mwh"	"2024-06-01 03:00:00+03"
16	2	683.00	"kWh"	"2024-07-01 03:00:00+03"
17	2	92235.00	"kWh"	"2024-08-01 03:00:00+03"
18	2	932783.00	"kWh"	"2024-09-01 03:00:00+03"
19	2	8689.00	"Mwh"	"2024-10-01 03:00:00+03"
20	2	578.00	"kwh"	"2024-11-01 02:00:00+02"
21	2	9457.00	"Mwh"	"2024-12-01 02:00:00+02"
22	2	3528.00	"kWh"	"2025-01-01 02:00:00+02"
23	2	739.00	"kWh"	"2025-02-01 02:00:00+02"
24	2	8.00	"kWh"	"2025-03-01 02:00:00+02"
25	3	9988.00	"Mwh"	"2024-04-01 03:00:00+03"
26	3	1356.00	"kWh"	"2024-05-01 03:00:00+03"
27	3	2975.00	"Mwh"	"2024-06-01 03:00:00+03"
28	3	695.00	"kWh"	"2024-07-01 03:00:00+03"
29	3	25589.00	"kWh"	"2024-08-01 03:00:00+03"
30	3	3456.00	"kWh"	"2024-09-01 03:00:00+03"
31	3	3.60	"Mwh"	"2024-10-01 03:00:00+03"
32	3	969.00	"kwh"	"2024-11-01 02:00:00+02"
33	3	443.77	"Mwh"	"2024-12-01 02:00:00+02"
34	3	3455555.00	"kWh"	"2025-01-01 02:00:00+02"
35	3	459999.00	"kWh"	"2025-02-01 02:00:00+02"
36	3	57353.00	"kWh"	"2025-03-01 02:00:00+02"


Frontend-URLs in Browser: 

http://localhost:5173/Christina/electric/1  (for customer 1, that is in my case "Chris")
http://localhost:5173/Christina/electric/2  (for customer 2, that is in my case "Tina")

Backend-URLs in Browser (for tests only, implementation can be later removed):
http://localhost:8080/Christina/CustConsum (there you can see the complete Backend-JSON out of the PostgreSQL database)
http://localhost:8080/Christina/CustConsum/hello (sends a greeting message to check, if the Backend is alive)
