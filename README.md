# IP2Location Programming Contest
Get visiotr IP address, country, region and city when they visited to <a href="https://vs.redmario.net/">https://vs.redmario.net/</a>

# Demo
<a href="https://vs.redmario.net/" target="_blank">IP2Location Programming Contest - Visitor System (Demo)</a>

# Introduction
<ul>
<li>A website system to record the IP address, country, region and city of visitor when they visit to <a href="https://vs.redmario.net/">https://vs.redmario.net/</a>.</li>
<li>Java, JSP, CSS, Javascript are used in this system.</li>
<li>All return datas such as country code, country name, region name, city name rerieved by using <a href="https://github.com/ip2location/ip2location-java" target="_blank">IP2Location™ IP Geolocation Java Component</a>.</li>
<li>On the database `ip2location`, table `visitor_history` used to record the visited history.</li>
</ul>

# Database
Below are the columns for table `visitor_history`.
<table>
<thead>
<tr>
<th>Column</th>
</tr>
<thead>
<tbody>
<tr><td>id</td></tr>
<tr><td>ip_address</td></tr>
<tr><td>country_code</td></tr>
<tr><td>country_name</td></tr>
<tr><td>region_name</td></tr>
<tr><td>city_name</td></tr>
<tr><td>last_visited_date</td></tr>
<tbody>
</table>
