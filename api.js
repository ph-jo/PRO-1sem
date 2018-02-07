"use strict";
var mm = {
    rows: 10,
    rowLength: 4,
    clearBoard: function() {
        $('#mmTable tr').each(function() {
            $(this).find('td').each(function() {
                $(this).removeClass('red');
                $(this).removeClass('blue');
                $(this).removeClass('green');
                $(this).removeClass('yellow');
                $(this).removeClass('orange');
                $(this).removeClass('purple');
                $(this).empty();
            })
        });
    },
    fillRow: function(row, color) {
        var cells = $('#mmTable tr')[mm.rows - row - 1].cells;
        for (var i = 0; i < 4; i++) {
            var e = cells[i];
            e.className = color;
        }
    },
    getRow: function(row) {
        var res = [];
        var cells = $('#mmTable tr')[mm.rows - row - 1].cells;
        for (var i = 0; i < 4; i++) {
            var e = cells[i];
            res.push(e.className);
        }
        return res;
    },
    addPin: function(color, row, column) {
        var cells = $('#mmTable tr')[mm.rows - row - 1].cells;
        cells[column].className = color;
    },
    addStatus: function(correctPins, correctColors, row) {
        var cells = $('#mmTable tr')[mm.rows - row - 1].cells;
        for (var i = 0; i < correctPins; i++) {
            cells[4].textContent = cells[4].textContent + 'X';
        }
        for (var i = 0; i < correctColors; i++) {
            cells[4].textContent = cells[4].textContent + 'O';
        }
    },
    getSelectedColor: function () {
        return $('input[name=color]:checked').val();
    },
    setMessage: function(msg) {
        $('#statusText').text(msg)
    }
};

$(document).ready(function() {
    $('#mmTable td:not([class])').click(function () {
        var column = parseInt( $(this).index() ) + 1;
        var row = parseInt( $(this).parent().index() ) + 1;
        row = mm.rows - row;
        column = column - 1;

        handleRow(row, column);
    });
});