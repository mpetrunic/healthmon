'use strict';

var gulp = require('gulp');

gulp.paths = {
  src: 'static',
  dist: 'static/dist',
  tmp: '.tmp'
};

require('require-dir')('./gulp');

gulp.task('default', ['clean'], function () {
    gulp.start('build');
});
