Google Play Services Advertising Id Client Hack
===================

This is a very small replacement of **com.google.android.gms:play-services-analytics** to save some method count (saves about 6200 methods - see images below). 
It also eliminates a transitive dependency to support-v4.

You can use this library **only** if you don't need the whole analytics package (i.e. all you need is advertising id for ad networks)

Before: ![before](https://dl.bintray.com/korniltsev-anatoly/generic/befre.png)

After: ![after](https://dl.bintray.com/korniltsev-anatoly/generic/after.png)

How does it work
-------------
It is a small subset of decompiled classes from original google play services version 7.5.0.
It was tested with facebook sdk, flurry, myTarget, fyber. **Please do tests to be sure your libraries receives correct advertising id.**

Usage
-------------
Remove all direct and transitive dependencies to google play services and add this lib (It won't work together with google play services).

    repositories {
        maven { url "http://dl.bintray.com/korniltsev-anatoly/maven" }
    }    
    compile 'ru.korniltsev.google-play-services-hacks:advertising-id-client:0.0.3'
