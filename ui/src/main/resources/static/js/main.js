$(document).ready(function() {
	var page = new Page();
	page.init();
});

function Page() {
	// this.name = prompt("Please provide your name:");
}

Page.prototype.init = function() {
	this.bind();
};

Page.prototype.bind = function() {
	this.bindNavigation();
};

Page.prototype.bindNavigation = function() {
	var that = this;
    // prompt("Please provide your name:");
    // alert("hello click!");
	$("#my-reservations").click(function() {
        // alert("hello click!");
        // $("#content").html("<a>hahaha </a>");
        $.post("http://localhost:5567/books/", function(data) {
				var html = "<h4>books</h4>";
				html += "<table>";
				html += "<tr>";
				html += "<th>bookId</th>"
				html += "<th>title</th>"
				html += "<th>pageCount</th>"
                html += "<th>authorFirstName</th>"
                html += "<th>authorLastName</th>"
				html += "</tr>"

				for (var x = 0; x < data.length; x++) {
					html += "<tr>";
					html += "<td>"+ data[x].bookId +"</td>";
					html += "<td>"+ data[x].title + "</td>";
					html += "<td>"+ data[x].pageCount +"</td>";
                    html += "<td>"+ data[x].authorFirstName +"</td>";
                    html += "<td>"+ data[x].authorLastName +"</td>";
					html += "</tr>";
				}
				html += "</table>";

				$("#content").html(html);
		})
	});

	$("#catalog").click(function() {
		$.post("http://localhost:5567/books", function(data) {
			var html = "<h4>books</h4>";
			html += "<table>";
			html += "<tr>";
			html += "<th>bookId</th>"
			html += "<th>title</th>"
			html += "<th>pageCount</th>"
			html += "<th>authorFirstName</th>"
			html += "<th></th>"
			html += "</tr>"
				
			for (var x = 0; x < data.length; x++) {
				html += "<tr>";
				html += "<td>"+ data[x].bookId +"</td>";
				html += "<td>"+ data[x].authorFirstName + ", " + data[x].authorLastName + "</td>";
				html += "<td>"+ data[x].pageCount +"</td>";
				html += "<td>"+ data[x].title +"</td>";
				html += "<td><a href=\"http://localhost:5567/book/{bookId}/" + data[x].bookId +"\" class=\"reserve-link\">Reserve</a></td>";
				html += "</tr>";
			}
			html += "</table>";
			
			$("#content").html(html);
			
			$("a").click(function(){return false;});
			$(".reserve-link").click(function(e){
				var href = $(this).attr("href");
				href = href.replace("{user}", that.name);
				$.post(href, function(data){
					alert(data);
				});
				return false;
			});
		})
	});
};