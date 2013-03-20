Voor het school project genaamd IRI


Specs:

Analog sensors
- 64 sens, digitalisering met een resolutie van 12 bits; scansnelheid 100 ms.
- 16 sens, digitalisering met een resolutie van 12 bits; scansnelheid 10 ms.

Digital sensors:
- 384 binary sens, (dus “1-bit” output per sensor); scansnelheid 10 ms.

- sensor locations: in en om reactor vat max 150 m verwijdert van serv.

LAN:
- 1 server
- 2 printers
- 10 workstations
- No internet

Real-time database:
- Op lan server
- Datastorage in working memory
- only most recent data.

database layout:
- sensor name max 40 chars
- sensor value in a number for binary on or off
- Gebruikte eenheid (graden bijvoorbeeld)
- timestamp year/month/day/hour/milisecond
-for non binary data: 
	voor de niet-binaire sensoren één veld met de naam van de alarmmelding als de
	ondergrens wordt overschreden en één veld met de naam van de alarmmelding als
	de bovengrens wordt overschreden.
-for binary data:
	voor de binaire sensoren één veld met de naam van de alarmmelding als de binaire
	sensor de waarde 1 (true) afgeeft; indien er geen alarm van toepassing is, dan moet
	dit veld de string “no alarm” bevatten.

report-application:
- most recent data
- if warning data, application must show it. + sound
- alarm-boundaries should be defineable
graph data: grafieken kunnen worden getoond, die het verloop van grootheden als functie van
de tijd weergeven. De grafieken moeten het verloop kunnen weergeven over de
laatste twee uur met tijdsintervallen van 1

- alarm data of last 12 hours
