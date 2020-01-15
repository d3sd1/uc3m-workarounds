<?php
// Make it a plain text file
header('Content-Type:text/plain');
// Output based on HTTP host
if($_SERVER['HTTP_HOST'] == 'sandbox.yumikey.com') {
    // Enter your test site robots.txt here
?>
User-agent: *
Disallow: /
<?php
}
else {
    // Enter your live site robots.txt here
?>
User-agent: *
Disallow: /cgi-bin/
User-agent: *
Disallow: /cgi/
<?php    
}
?>