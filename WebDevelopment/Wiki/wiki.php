<?php
$value = 'cookie monster loves cookies';
setcookie("TestCookie", $value, time()+3600);
?>

<?php
echo $_COOKIE["TestCookie"];
?>

<?php
session_start();
?>


<!DOCTYPE html>
<html>
    <head>
        <title>A Wiki about Skydiving</title>
        <meta charset="UTF-8"> 
        <link rel = "stylesheet" type = "text/css" href = "wiki.css"/>
    
    </head>
 
    <body>
    
        <?php
        $_SESSION["user"] = "UserPerson";
        echo 'session set for userperson';
        ?>
    
    
        <div class = "topBar">
            <div class = "topButtons">
                <button id = "sgninbtn">Log In</button></a>
                <button>Sign Out</button></a>
            </div>
            
            <div id = "signIn">
                <form id = "userName" method = "post" action = "wiki.php">
                    <input type = "text" id = "usrnm" class = "usrnmInput" size = "20" maxlength = "120" placeholder = "Username"></input>
                    <input type = "text" id = "psswrd" class = "psswrdInput" size = "20" maxlength = "120" placeholder = "Password"></input>
                    <input type = "submit" value = "Log in" id = "submitLogin"></input>
                </form>
            </div>
        </div>
    
    
        <div class = "header">
            <img src = "skydiving.jpeg" />
        </div>
        
        
        <div class = "sidebar">
            <div class = "about">
                <h6>About this wiki</h6>
                <p>This is a wiki about the sport of skydiving. Registered users can log in and post in the discussion board or make edits to the wiki as appropriate.</p>
            </div>
            <div class = "navigation">
                <h6>Navigation</h6>
                <ul>
                    <li><a href="http://google.com/">Home</a></li>
                    <li><a href="http://google.com/">Discussion</a></li>
                    <li><a href="http://google.com/">Sky diving wiki</a></li>
                    <li><a href="http://google.com/">Change history</a></li>
                </ul>
            </div>
            
            <div class = "searchForm">
                <form id = "searchBox" method = "get" action = "http://www.google.com">
                    <input type = "text" id = "srch" size = "20" maxlength = "120" placeholder = "Search this wiki"><input type = "submit" value = "Go" id = "srchGo"></input>
                </form>
		<div class="tfclear"></div>
            </div>
            
            
        </div>
        
        <div class = "contentArea">
            <h4>Skydiving</h4>
            <div class = "contentButtons">
                <button id = "homebtn">Home</button></a>
                <button id = "sdbtn">Skydiving page</button></a>
                <button id = dscnbtn">Discussion</button></a>
                <button id = "historybtn">Change History</button></a>
            </div>
            
            <div id = "content" class = "toggle">
                <!-- <img src = "skydiving.jpeg" /> -->
                <h5>History of the sport</h5>
                <p><strong>Parachuting</strong>, or <strong>skydiving</strong>, is a method of transiting from a high point to Earth with the aid of gravity, involving the control of speed during the descent with the use of a parachute. It may involve more or less free-fall, a time during which the parachute has not been deployed and the body gradually accelerates to terminal velocity.

                Andre-Jacques Garnerin was the first to make successful descents using a canvas canopy from a small basket tethered beneath a hot-air balloon. The first intentional freefall jump with a ripcord-operated deployment is credited to Leslie Irvin in 1919. Georgia Broadwick made an earlier freefall in 1914 using improvised equipment when her static line became entangled with the aircraft's tail assembly and she cut the static line and pulled it herself.

                The military developed parachuting technology as a way to save aircrews from emergencies aboard balloons and aircraft in flight, and later as a way of delivering soldiers to the battlefield. Early competitions date back to the 1930s, and it became an international sport in 1952.
            
                Parachuting is performed as recreational activity, and a competitive sport which is widely considered an extreme sport due to the risks involved. Modern militaries utilize parachuting for the deployment of airborne forces and supplies, and special operations forces commonly employ parachuting, especially free-fall parachuting, as a method of insertion. Occasionally forest firefighters, known as "smokejumpers" in the United States, use parachuting as a means of rapidly inserting themselves near forest fires in especially remote or otherwise inaccessible areas.</p>

                <h5>Common uses of skydiving</h5>
                <p>Manually exiting an aircraft and parachuting to safety has been widely used by aviators (especially military aviators and aircrew), and passengers to escape an aircraft that could not otherwise land safely. While this method of escape is relatively rare in modern times, it was commonly used in World War I by military aviators, and utilized extensively throughout the air wars of World War II. In modern times, the most common means of escape from an aircraft in distress is via an ejection seat. Said system is usually operated by the pilot, aircrew member, or passenger, by engaging an activation device manually. In most designs, this will lead to the seat being propelled out of and away from the aircraft carrying the occupant with it, by means of either an explosive charge or a rocket propulsion system. Once clear of the aircraft, the ejection seat will deploy a parachute, although some older models entrusted this step to manual activation by the seat's occupant.</p>
            
                <h5>Safety</h5>
                <p>Despite the perception of danger, fatalities are rare. About 21 skydivers are confirmed killed each year in the US, roughly one death for every 150,000 jumps (about 0.0007%).

                In the US and in most of the western world, skydivers are required to carry two parachutes. The reserve parachute must be periodically inspected and re-packed (whether used or not) by a certified parachute rigger (in the US, an FAA certificated parachute rigger). Many skydivers use an automatic activation device (AAD) that opens the reserve parachute at a pre-determined altitude if it detects that the skydiver is still in free fall. Depending on the country, AADs are often mandatory for new jumpers, and/or required for all jumpers regardless of their experience level. Most skydivers wear a visual altimeter, and an increasing number also use audible altimeters fitted to their helmets.

                Injuries and fatalities occurring under a fully functional parachute usually happen because the skydiver performed unsafe maneuvers or made an error in judgment while flying their canopy, typically resulting in a high-speed impact with the ground or other hazards on the ground. One of the most common sources of injury is a low turn under a high-performance canopy and while swooping. Swooping is the advanced discipline of gliding at high-speed parallel to the ground during landing.

                Changing wind conditions are another risk factor. In conditions of strong winds, and turbulence during hot days the parachutist can be caught in downdrafts close to the ground. Shifting winds can cause a crosswind or downwind landing which have a higher potential for injury due to the wind speed adding to the landing speed.

                Another risk factor is that of "canopy collisions", or collisions between two or more skydivers under fully inflated parachutes. Canopy collisions can cause the jumpers' inflated parachutes to entangle with each other, often resulting in a sudden collapse (deflation) of one or more of the involved parachutes. When this occurs, the jumpers often must quickly perform emergency procedures (if there is sufficient altitude to do so) to "cut-away" (jettison) from their main canopies and deploy their reserve canopies. Canopy collisions are particularly dangerous when occurring at altitudes too low to allow the jumpers adequate time to safely jettison their main parachutes and fully deploy their reserve parachutes.

                Equipment failure rarely causes fatalities and injuries. Approximately one in 750 deployments of a main parachute result in a malfunction.[6] Ram-air parachutes typically spin uncontrollably when malfunctioning, and must be jettisoned before deploying the reserve parachute. Reserve parachutes are packed and deployed differently; they are also designed more conservatively and built and tested to more exacting standards so they are more reliable than main parachutes, but the real safety advantage comes from the probability of an unlikely main malfunction multiplied by the even less likely probability of a reserve malfunction. This yields an even smaller probability of a double malfunction although the possibility of a main malfunction that cannot be cutaway causing a reserve malfunction is a very real risk.

                Parachuting disciplines such as BASE jumping or those that involve equipment such as wing suit flying and sky surfing have a higher risk factor due to the lower mobility of the jumper and the greater risk of entanglement. For this reason,[tone] these disciplines are generally practiced by experienced jumpers.

                Depictions in commercial films – notably Hollywood action movies[citation needed] – usually overstate the dangers of the sport.[tone] Often, the characters in such films are shown performing feats that are physically impossible without special effects assistance. In other cases, their practices would cause them to be grounded or shunned at any safety-conscious drop zone or club. USPA member drop zones in the US and Canada are required to have an experienced jumper act as a "safety officer" (in Canada DSO – Drop Zone Safety Officer; in the U.S. STA – Safety and Training Advisor) who is responsible for dealing with jumpers who violate rules, regulations, or otherwise act in a fashion deemed unsafe by the appointed individual.

                In many countries, either the local regulations or the liability-conscious prudence of the drop zone owners require that parachutists must have attained the age of majority before engaging in the sport.</p>
            
                <h5>Most common injuries in Skydiving and their causes</h5>
                <p>Due to the hazardous nature of skydiving, the greatest of precautions are taken to avoid parachuting injuries and death. For first time solo-parachutists, this includes anywhere from 4 to 8 hours of ground instruction.[7] Since the majority of parachute injuries occur upon landing (approximately 85%),[8] the greatest emphasis within ground training is usually on the proper parachute landing fall (PLF), which seeks to orient the body as to evenly disperse the impact through flexion of several large, insulating muscles (such as the medial gastrocnemius, tibialis anterior, rectus femoris, vastus medialis, biceps femoris, and semitendinosus ),[9] as opposed to individual bones, tendons, and ligaments which break and tear more easily.

                Parachutists, especially those flying smaller sport canopies, often land with dangerous amounts of kinetic energy, and for this reason, improper landings are the cause of more than 30% of all skydiving related injuries and deaths.[8] Often, injuries sustained during parachute landing are caused when a single outstretched limb, such as a hand or foot, is extended separately from the rest of the body, causing it to sustain forces disproportional to the support structures within. This tendency is displayed in the following chart, which shows the significantly higher proportion of wrist and ankle injuries among the 186 injured in a 110,000 parachute jump study:

                Due to the possibility of fractures (commonly occurring on the tibia and the ankle mortise), it is recommended that parachutists wear supportive footwear.[8] Supportive footwear prevents inward and outward ankle rolling, allowing the PLF to safely transfer impact energy through the true ankle joint, and dissipate it via the medial gastrocnemius and tibialis anterior muscles.</p>

                <h6>Weather</h6>
                <p>Parachuting in poor weather, especially with thunderstorms, high winds, and dust devils can be a dangerous activity. Reputable drop zones will suspend normal operations during inclement weather. In the United States, the USPA's Basic Safety Requirements prohibit solo student skydivers from jumping in winds exceeding 14 mph while using ram-air equipment. However, maximum ground winds are unlimited for licensed skydivers.</p>

                <h6>Visibility</h6>
                <p>As parachuting is an aviation activity under the visual flight rules,[11] it is generally illegal to jump in or through clouds, according to the relevant rules governing the airspace, such as FAR105[12] in the US or Faldskærmsbestemmelser (Parachuting Ordinances)[13] in Denmark. Jumpers and pilots of the dropping aircraft similarly bear responsibility of following the other VFR elements,[11] in particular ensuring that the air traffic at the moment of jump does not create a hazard.</p>

                <h6>Canopy collision</h6>
                <p>A collision with another canopy is a statistical hazard, and may be avoided by observing simple principles, including knowing upper wind speeds, the number of party members and exit groups, and having sufficient exit separation between jumpers.[14] In 2013, 17% of all skydiving fatalities in the United States resulted from mid-air collisions.</p>
            </div>
            
            <div class = "editButton">
                <a href="http://google.com"><button>Edit</button></a>
            </div>
            
            
            
            
            <div id = "home" class = "toggle">
                <h5>Home</h5>
                <p>Some info about this wiki and stuff I guess</p>
            </div>
            
            
            <div id = "discussion" class = "toggle">
                <h5>Discussion Board</h5>
                <p>Some discussion posts about this skydiving wiki. Show previous comments saved<p>
                
                <form id = "discuss" method = "post" action = "wiki.php">
                    <textarea id = "dscnPost" rows = "8" cols = "140" maxlength = "1200" placeholder = "Enter text here to add to the discussion"></textarea>
                    <input type = "submit" value = "Submit" id = "submitDscn"></input>
                </form>
                
                
                <?php
                if(isset($_POST['dscnPost'])) {
                    $data = $_POST['dscnPost'] . "\n";
                    $ret = file_put_contents('Wiki/discussion.txt', $data, FILE_APPEND | LOCK_EX);
                    if($ret === false) {
                        die('There was an error writing this file');
                    }
                    else {
                        echo "$ret bytes written to file";
                    }
                }
                else {
                    die('No post data to process');
                }
                ?>
                
            </div>
            
            
            <div id = "history" class = "toggle">
                <h5>Change history</h5>
                <p>A history of changes to the wiki from php</p>
            </div>
            
            
        </div>
        
 
        <script src = "wiki.js" type = "text/javascript"></script>
    </body>
 
 </html>
 
