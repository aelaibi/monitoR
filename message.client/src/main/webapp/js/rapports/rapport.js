
$(document).ready(function(){
	
	var margin = {top: 20, right: 40, bottom: 30, left: 20},
    width = 660 - margin.left - margin.right,
    height = 300 - margin.top - margin.bottom,
    barWidth = Math.floor(width / 19) - 1;

var x = d3.scale.linear()
    .range([width -barWidth / 2, barWidth / 2]);

var y = d3.scale.linear()
    .range([height, 0]);

var yAxis = d3.svg.axis()
    .scale(y)
    .orient("left")
    .tickSize(width)
    .tickFormat(function(d) { return Math.round(d / 1e6) + "M"; });

// An SVG element with a bottom-right origin.
var svg = d3.select("body").append("svg")
    .attr("width", width + margin.left + margin.right)
    .attr("height", height + margin.top + margin.bottom)
    .append("g")
    .attr("transform", "translate(" + margin.left + "," + margin.top + ")");

// A sliding container to hold the bars by birthyear.
var birthyears = svg.append("g")
    .attr("class", "birthyears");
console.debug(birthyears);
// A label for the current year.
var title = svg.append("text")
    .attr("class", "title")
    .attr("dy", ".71em")
    .text(2000);


var data = [{year: 1850, age: 0, sex: 1, people:  1483789},
             {year: 1850, age: 10, sex: 1, people: 1220099},
             {year: 1850, age: 15, sex: 1, people: 1260099},
             {year: 1850, age: 30, sex: 2, people: 1399668},
             {year: 1850, age: 50, sex: 2, people: 583789},
             {year: 1850, age: 60, sex: 1, people: 20099},
             {year: 1850, age: 65, sex: 1, people: 60099},
             {year: 1850, age: 70, sex: 2, people: 59668},
             
             {year: 1860, age: 0, sex: 1, people:  1683789},
             {year: 1860, age: 10, sex: 1, people: 1320099},
             {year: 1860, age: 15, sex: 1, people: 1460099},
             {year: 1860, age: 30, sex: 2, people: 1199668},
             {year: 1860, age: 50, sex: 2, people: 283789},
             {year: 1860, age: 60, sex: 1, people: 40099},
             {year: 1860, age: 65, sex: 1, people: 50099},
             {year: 1860, age: 70, sex: 2, people: 69668},
             
             {year: 1870, age: 0, sex: 1, people:  1883789},
             {year: 1870, age: 10, sex: 1, people: 1520099},
             {year: 1870, age: 15, sex: 1, people: 1560099},
             {year: 1870, age: 30, sex: 2, people: 1399668},
             {year: 1870, age: 50, sex: 2, people: 383789},
             {year: 1870, age: 60, sex: 1, people: 40199},
             {year: 1870, age: 65, sex: 1, people: 51199},
             {year: 1870, age: 70, sex: 2, people: 39668},
                 ]; 

//d3.csv("population.csv", function(error, data) {

  // Convert strings to numbers.
  data.forEach(function(d) {
    d.people = +d.people;
    d.year = +d.year;
    d.age = +d.age;
  });

  // Compute the extent of the data set in age and years.
  var age1 = d3.max(data, function(d) { return d.age; }),
      year0 = d3.min(data, function(d) { return d.year; }),
      year1 = d3.max(data, function(d) { return d.year; }),
      year = year1;

  // Update the scale domains.
  x.domain([year1 - age1, year1]);
  y.domain([0, d3.max(data, function(d) { return d.people; })]);
  
  // Produce a map from year and birthyear to [male, female].
  data = d3.nest()
      .key(function(d) { return d.year; })
      .key(function(d) { return d.year - d.age; })
      .rollup(function(v) { return v.map(function(d) { return d.people; }); })
      .map(data);
  
  console.debug(data);
  
  for (var i in data) {
      console.log( i + " : " + data[i] + "\n");
      for (var j in data[i]) {
    	  console.log("==> " + j + " : " + data[i][j] + "\n");
    	  for (var h in data[j]) {
        	  console.log("==  ==> " + h + " : " + data[i][j][h] + "\n");
    	  }
      }
  }
  
  // Add an axis to show the population values.
  svg.append("g")
      .attr("class", "y axis")
      .attr("transform", "translate(" + width + ",0)")
      .call(yAxis)
      .selectAll("g")
      .filter(function(value) {  console.log(value);return !value; })
      .classed("major", true);

  // Add labeled rects for each birthyear (so that no enter or exit is required).
  var birthyear = birthyears.selectAll(".birthyear")
      .data(d3.range(year0 - age1, year1 + 1, 5))
      .enter().append("g")
      .attr("class", "birthyear")
      .attr("transform", function(birthyear) { return "translate(" + x(birthyear) + ",0)"; });

  birthyear.selectAll("rect")
      .data(function(birthyear) { return data[year][birthyear] || [0, 0]; })
      .enter().append("rect")
      .attr("x", -barWidth / 2)
      .attr("width", barWidth)
      .attr("y", y)
      .attr("height", function(value) { return height - y(value); });

  // Add labels to show birthyear.
  birthyear.append("text")
      .attr("y", height - 4)
      .text(function(birthyear) { return birthyear; });

  // Add labels to show age (separate; not animated).
  svg.selectAll(".age")
      .data(d3.range(0, age1 + 1, 5))
    .enter().append("text")
      .attr("class", "age")
      .attr("x", function(age) { return x(year - age); })
      .attr("y", height + 4)
      .attr("dy", ".71em")
      .text(function(age) { return age; });

  // Allow the arrow keys to change the displayed year.
  window.focus();
  d3.select(window).on("keydown", function() {
    switch (d3.event.keyCode) {
      case 37: year = Math.max(year0, year - 10); break;
      case 39: year = Math.min(year1, year + 10); break;
    }
    update();
  });

  function update() {
    if (!(year in data)) return;
    title.text(year);

    birthyears.transition()
        .duration(750)
        .attr("transform", "translate(" + (x(year1) - x(year)) + ",0)");

    birthyear.selectAll("rect")
        .data(function(birthyear) { return data[year][birthyear] || [0, 0]; })
      .transition()
        .duration(750)
        .attr("y", y)
        .attr("height", function(value) { return height - y(value); });
  }
//});
	
});



