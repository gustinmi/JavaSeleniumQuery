function App(title) {
	this.titleTxt = title;
    this.root = {};
}

App.prototype = {

	register : function(name, factory){
		this.root[name] = factory(this);
	},

	search : function(evt){

			var filteredPublicationData = [],
				searchTerm = $('.search-input').val();

			// dummy search implementation
			$(window.publicationData).each(function(idx, elt){

				if (elt.naziv.toLowerCase().indexOf(searchTerm.toLowerCase()) >= 0)
					filteredPublicationData.push(elt);

	        });

			// show all on app load
			app.root.results.show(filteredPublicationData);

			return false;


	},

    onStart: function() {
		'use strict';
		this.root.menu.start();
		this.title();

		$('.top-container').on('click', function(){
			$("html, body").animate({ scrollTop: 0 }, "slow");
			return false;
		});

 		$('.search-input').keyup(function(e) {
            
        	if ($(this).val().length > 3)
            	App.prototype.search();
        
            return false;
        });


		$('.buttonSearch').on('click', this.search);
		
		app.root.results.show();

    },

    title : function(title){
    	
		$('title').text(title ? this.titleTxt + " - " + title : this.titleTxt);

    },

    hashchange : function(hash){
    	console.log("Hash changed" + hash);
    	// todo : support bookmarkable urls
    }

};

// bootstrap sequence

(function(){
	var app = new App("javaselkju"); 
	window.app = app;
	window.register = app.register;
	document.addEventListener("DOMContentLoaded", function() {
		app.onStart();	
	});
	window.addEventListener("hashchange",function(){
		app.hashchange(document.location.hash);
	});
})();